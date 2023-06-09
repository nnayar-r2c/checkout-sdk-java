package com.checkout.workflows.conditions.request;

import com.checkout.workflows.conditions.WorkflowConditionType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class EventWorkflowConditionRequest extends WorkflowConditionRequest {

    private Map<String, Set<String>> events;

    public EventWorkflowConditionRequest() {
        super(WorkflowConditionType.EVENT);
    }

    @Builder
    private EventWorkflowConditionRequest(final Map<String, Set<String>> events) {
        super(WorkflowConditionType.EVENT);
        this.events = events;
    }

}
