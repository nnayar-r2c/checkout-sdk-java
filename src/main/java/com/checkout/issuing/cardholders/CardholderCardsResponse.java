package com.checkout.issuing.cardholders;

import com.checkout.HttpMetadata;
import com.checkout.issuing.cards.responses.CardDetailsResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CardholderCardsResponse extends HttpMetadata {

    private List<CardDetailsResponse> cards;
}
