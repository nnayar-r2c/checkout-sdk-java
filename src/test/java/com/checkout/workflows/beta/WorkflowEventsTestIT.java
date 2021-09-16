package com.checkout.workflows.beta;

import com.checkout.payments.beta.response.PaymentResponse;
import com.checkout.payments.beta.response.source.ResponseCardSource;
import com.checkout.workflows.beta.events.Event;
import com.checkout.workflows.beta.events.EventTypesResponse;
import com.checkout.workflows.beta.events.GetEventResponse;
import com.checkout.workflows.beta.events.SubjectEvent;
import com.checkout.workflows.beta.events.SubjectEventsResponse;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WorkflowEventsTestIT extends AbstractWorkflowTestIT {

    @Test
    void shouldGetEventTypes() {

        final List<EventTypesResponse> eventTypesResponse = blocking(getApiV2().workflowsClient().getEventTypes());

        assertNotNull(eventTypesResponse);
        assertFalse(eventTypesResponse.isEmpty());

        for (final EventTypesResponse typesResponse : eventTypesResponse) {
            assertNotNull(typesResponse.getId());
            assertNotNull(typesResponse.getDisplayName());
            assertNotNull(typesResponse.getEvents());
            for (final Event event : typesResponse.getEvents()) {
                assertNotNull(event.getId());
                assertNotNull(event.getDisplayName());
                assertNotNull(event.getDescription());
            }
        }

    }

    @Test
    void shouldGetSubjectEventAndEvents() {

        createWorkflow();

        final PaymentResponse<ResponseCardSource> payment = makeCardPayment(false);

        nap(5);

        capturePayment(payment.getId());

        nap(10);

        final SubjectEventsResponse subjectEventsResponse = blocking(getApiV2().workflowsClient().getSubjectEvents(payment.getId()));

        assertNotNull(subjectEventsResponse);
        assertEquals(2, subjectEventsResponse.getEvents().size());

        final SubjectEvent paymentApprovedEvent = subjectEventsResponse.getEvents().stream()
                .filter(event -> event.getType().equals(PAYMENT_APPROVED))
                .findFirst()
                .orElse(null);

        assertNotNull(paymentApprovedEvent);
        assertNotNull(paymentApprovedEvent.getId());
        assertNotNull(paymentApprovedEvent.getTimestamp());
        assertNotNull(paymentApprovedEvent.getLink(SELF));

        final SubjectEvent paymentCapturedEvent = subjectEventsResponse.getEvents().stream()
                .filter(event -> event.getType().equals(PAYMENT_CAPTURED))
                .findFirst()
                .orElse(null);

        assertNotNull(paymentCapturedEvent);
        assertNotNull(paymentCapturedEvent.getId());
        assertNotNull(paymentCapturedEvent.getTimestamp());
        assertNotNull(paymentCapturedEvent.getLink(SELF));

        // Get event
        final GetEventResponse getEventResponse = blocking(getApiV2().workflowsClient().getEvent(paymentCapturedEvent.getId()));

        assertNotNull(getEventResponse);
        assertNotNull(getEventResponse.getId());
        assertEquals(GATEWAY, getEventResponse.getSource());
        assertEquals(PAYMENT_CAPTURED, getEventResponse.getType());
        assertNotNull(getEventResponse.getTimestamp());
        assertNotNull(getEventResponse.getVersion());
        assertNotNull(getEventResponse.getData());
        assertFalse(getEventResponse.getData().isEmpty());

    }

}