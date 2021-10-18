package com.checkout.payments.four.sender;

import com.checkout.common.Address;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public final class RequestCorporateSender extends RequestSender {

    @SerializedName("company_name")
    private String companyName;

    private Address address;

    @Builder
    private RequestCorporateSender(final String companyName, final Address address) {
        super(RequestSenderType.CORPORATE);
        this.companyName = companyName;
        this.address = address;
    }

    public RequestCorporateSender() {
        super(RequestSenderType.CORPORATE);
    }

}