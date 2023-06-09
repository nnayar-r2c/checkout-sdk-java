package com.checkout.accounts;

import com.checkout.CheckoutApi;
import com.checkout.CheckoutSdk;
import com.checkout.Environment;
import com.checkout.OAuthScope;
import com.checkout.accounts.payout.schedule.DaySchedule;
import com.checkout.accounts.payout.schedule.request.ScheduleFrequencyDailyRequest;
import com.checkout.accounts.payout.schedule.request.ScheduleFrequencyMonthlyRequest;
import com.checkout.accounts.payout.schedule.request.ScheduleFrequencyWeeklyRequest;
import com.checkout.accounts.payout.schedule.request.UpdateScheduleRequest;
import com.checkout.accounts.payout.schedule.response.CurrencySchedule;
import com.checkout.accounts.payout.schedule.response.GetScheduleResponse;
import com.checkout.accounts.payout.schedule.response.ScheduleFrequencyDailyResponse;
import com.checkout.accounts.payout.schedule.response.ScheduleFrequencyMonthlyResponse;
import com.checkout.accounts.payout.schedule.response.ScheduleFrequencyWeeklyResponse;
import com.checkout.accounts.payout.schedule.response.VoidResponse;
import com.checkout.common.Currency;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.concurrent.ExecutionException;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AccountsPayoutSchedulesIT {

    @Test
    @Disabled("not available")
    void shouldUpdateAndRetrieveWeeklyPayoutSchedules() throws ExecutionException, InterruptedException {

        final UpdateScheduleRequest updateScheduleRequest = UpdateScheduleRequest.builder()
                .enabled(true)
                .threshold(1000)
                .recurrence(ScheduleFrequencyWeeklyRequest.builder()
                        .byDays(Collections.singletonList(DaySchedule.MONDAY))
                        .build())
                .build();

        final VoidResponse scheduleResponse = getPayoutSchedulesCheckoutApi().accountsClient()
                .updatePayoutSchedule("ent_sdioy6bajpzxyl3utftdp7legq", Currency.USD, updateScheduleRequest).get();

        assertNotNull(scheduleResponse);

        final GetScheduleResponse GetScheduleResponse = getPayoutSchedulesCheckoutApi().accountsClient()
                .retrievePayoutSchedule("ent_sdioy6bajpzxyl3utftdp7legq").get();

        assertNotNull(GetScheduleResponse);
        assertNotNull(GetScheduleResponse.getCurrency());
        assertFalse(GetScheduleResponse.getCurrency().isEmpty());
        assertNotNull(GetScheduleResponse.getLinks());
        assertFalse(GetScheduleResponse.getLinks().isEmpty());

        final CurrencySchedule schedule = GetScheduleResponse.getCurrency().get(Currency.USD);
        assertNotNull(schedule.getEnabled());
        assertNotNull(schedule.getThreshold());
        assertNotNull(schedule.getRecurrence());
        assertTrue(schedule.getRecurrence() instanceof ScheduleFrequencyWeeklyResponse);
        assertNotNull(schedule.getRecurrence().getFrequency());
        assertNotNull(((ScheduleFrequencyWeeklyResponse) schedule.getRecurrence()).getByDay());
    }

    @Test
    @Disabled("not available")
    void shouldUpdateAndRetrieveDailyPayoutSchedules() throws ExecutionException, InterruptedException {

        final UpdateScheduleRequest updateScheduleRequest = UpdateScheduleRequest.builder()
                .enabled(true)
                .threshold(1000)
                .recurrence(new ScheduleFrequencyDailyRequest())
                .build();

        final VoidResponse scheduleResponse = getPayoutSchedulesCheckoutApi().accountsClient()
                .updatePayoutSchedule("ent_sdioy6bajpzxyl3utftdp7legq", Currency.USD, updateScheduleRequest).get();

        assertNotNull(scheduleResponse);

        final GetScheduleResponse GetScheduleResponse = getPayoutSchedulesCheckoutApi().accountsClient()
                .retrievePayoutSchedule("ent_sdioy6bajpzxyl3utftdp7legq").get();

        assertNotNull(GetScheduleResponse);
        assertNotNull(GetScheduleResponse.getCurrency());
        assertFalse(GetScheduleResponse.getCurrency().isEmpty());
        assertNotNull(GetScheduleResponse.getLinks());
        assertFalse(GetScheduleResponse.getLinks().isEmpty());

        final CurrencySchedule schedule = GetScheduleResponse.getCurrency().get(Currency.USD);
        assertNotNull(schedule.getEnabled());
        assertNotNull(schedule.getThreshold());
        assertNotNull(schedule.getRecurrence());
        assertTrue(schedule.getRecurrence() instanceof ScheduleFrequencyDailyResponse);
        assertNotNull(schedule.getRecurrence().getFrequency());
    }

    @Test
    @Disabled("not available")
    void shouldUpdateAndRetrieveMonthlyPayoutSchedules() throws ExecutionException, InterruptedException {

        final UpdateScheduleRequest updateScheduleRequest = UpdateScheduleRequest.builder()
                .enabled(true)
                .threshold(1000)
                .recurrence(ScheduleFrequencyMonthlyRequest.builder()
                        .byMonthDays(Collections.singletonList(15))
                        .build())
                .build();

        final VoidResponse scheduleResponse = getPayoutSchedulesCheckoutApi().accountsClient()
                .updatePayoutSchedule("ent_sdioy6bajpzxyl3utftdp7legq", Currency.USD, updateScheduleRequest).get();

        assertNotNull(scheduleResponse);

        final GetScheduleResponse GetScheduleResponse = getPayoutSchedulesCheckoutApi().accountsClient()
                .retrievePayoutSchedule("ent_sdioy6bajpzxyl3utftdp7legq").get();

        assertNotNull(GetScheduleResponse);
        assertNotNull(GetScheduleResponse.getCurrency());
        assertFalse(GetScheduleResponse.getCurrency().isEmpty());
        assertNotNull(GetScheduleResponse.getLinks());
        assertFalse(GetScheduleResponse.getLinks().isEmpty());

        final CurrencySchedule schedule = GetScheduleResponse.getCurrency().get(Currency.USD);
        assertNotNull(schedule.getEnabled());
        assertNotNull(schedule.getThreshold());
        assertNotNull(schedule.getRecurrence());
        assertTrue(schedule.getRecurrence() instanceof ScheduleFrequencyMonthlyResponse);
        assertNotNull(schedule.getRecurrence().getFrequency());
        assertNotNull(((ScheduleFrequencyMonthlyResponse) schedule.getRecurrence()).getByMonthDay());
    }

    private CheckoutApi getPayoutSchedulesCheckoutApi() {
        return CheckoutSdk.builder()
                .oAuth()
                .clientCredentials(
                        requireNonNull(System.getenv("CHECKOUT_DEFAULT_OAUTH_PAYOUT_SCHEDULE_CLIENT_ID")),
                        requireNonNull(System.getenv("CHECKOUT_DEFAULT_OAUTH_PAYOUT_SCHEDULE_CLIENT_SECRET")))
                .scopes(OAuthScope.MARKETPLACE)
                .environment(Environment.SANDBOX)
                .build();
    }

}