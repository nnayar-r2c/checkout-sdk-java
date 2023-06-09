package com.checkout.payments;

import com.checkout.common.AmountAllocations;
import com.checkout.common.MarketplaceData;
import com.checkout.common.Resource;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class PaymentAction extends Resource {

    private String id;

    private ActionType type;

    @SerializedName("processed_on")
    private Instant processedOn;

    private Long amount;

    private Boolean approved;

    @SerializedName("auth_code")
    private String authCode;

    @SerializedName("response_code")
    private String responseCode;

    @SerializedName("response_summary")
    private String responseSummary;

    @SerializedName("authorization_type")
    private AuthorizationType authorizationType;

    private String reference;

    /**
     * @deprecated This property will be removed in the future, and should be used
     * {@link PaymentAction#amountAllocations} instead
     */
    @Deprecated
    private MarketplaceData marketplace;

    @SerializedName("amount_allocations")
    private List<AmountAllocations> amountAllocations;

    private Processing processing;

    private Map<String, Object> metadata = new HashMap<>();

}