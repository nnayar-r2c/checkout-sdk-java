package com.checkout.accounts.payout.schedule.response;

import com.checkout.accounts.payout.schedule.ScheduleFrequency;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class ScheduleFrequencyDailyResponse extends ScheduleResponse {

    public ScheduleFrequencyDailyResponse() {
        super(ScheduleFrequency.DAILY);
    }
}
