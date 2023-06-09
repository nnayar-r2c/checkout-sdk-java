package com.checkout.accounts;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class Capabilities {

    private Payments payments;

    private Payouts payouts;

    @Data
    public static class Payments {

        private boolean available;

        private boolean enabled;

    }

    @Data
    public static class Payouts {

        private boolean available;

        private boolean enabled;

    }

}
