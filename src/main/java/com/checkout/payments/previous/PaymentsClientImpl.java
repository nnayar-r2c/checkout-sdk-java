package com.checkout.payments.previous;

import static com.checkout.common.CheckoutUtils.validateParams;

import com.checkout.AbstractClient;
import com.checkout.ApiClient;
import com.checkout.CheckoutConfiguration;
import com.checkout.ItemsResponse;
import com.checkout.SdkAuthorizationType;
import com.checkout.payments.CaptureRequest;
import com.checkout.payments.CaptureResponse;
import com.checkout.payments.RefundRequest;
import com.checkout.payments.RefundResponse;
import com.checkout.payments.VoidRequest;
import com.checkout.payments.VoidResponse;
import com.checkout.payments.previous.request.PaymentRequest;
import com.checkout.payments.previous.request.PayoutRequest;
import com.checkout.payments.previous.response.GetPaymentResponse;
import com.checkout.payments.previous.response.PaymentResponse;
import com.checkout.payments.PaymentsQueryFilter;
import com.checkout.payments.previous.response.PaymentsQueryResponse;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

public class PaymentsClientImpl extends AbstractClient implements PaymentsClient {

    private static final String PAYMENTS_PATH = "payments";
    private static final String ACTIONS_PATH = "actions";
    private static final String CAPTURES_PATH = "captures";
    private static final String REFUNDS_PATH = "refunds";
    private static final String VOIDS_PATH = "voids";

    private static final Type PAYMENT_ACTIONS_TYPE = new TypeToken<ItemsResponse<PaymentAction>>() {
    }.getType();

    public PaymentsClientImpl(final ApiClient apiClient, final CheckoutConfiguration configuration) {
        super(apiClient, configuration, SdkAuthorizationType.SECRET_KEY);
    }

    @Override
    public CompletableFuture<PaymentResponse> requestPayment(final PaymentRequest paymentRequest) {
        validateParams("paymentRequest", paymentRequest);
        return apiClient.postAsync(PAYMENTS_PATH, sdkAuthorization(), PaymentResponse.class, paymentRequest, null);
    }

    @Override
    public CompletableFuture<PaymentResponse> requestPayment(final PaymentRequest paymentRequest, final String idempotencyKey) {
        validateParams("paymentRequest", paymentRequest, "idempotencyKey", idempotencyKey);
        return apiClient.postAsync(PAYMENTS_PATH, sdkAuthorization(), PaymentResponse.class, paymentRequest, idempotencyKey);
    }

    @Override
    public CompletableFuture<PaymentResponse> requestPayout(final PayoutRequest payoutRequest) {
        validateParams("payoutRequest", payoutRequest);
        return apiClient.postAsync(PAYMENTS_PATH, sdkAuthorization(), PaymentResponse.class, payoutRequest, null);
    }

    @Override
    public CompletableFuture<PaymentResponse> requestPayout(final PayoutRequest payoutRequest, final String idempotencyKey) {
        validateParams("payoutRequest", payoutRequest, "idempotencyKey", idempotencyKey);
        return apiClient.postAsync(PAYMENTS_PATH, sdkAuthorization(), PaymentResponse.class, payoutRequest, idempotencyKey);
    }

    @Override
    public CompletableFuture<PaymentsQueryResponse> getPaymentsList(final PaymentsQueryFilter queryFilter) {
        validateParams("queryFilter", queryFilter);
        return apiClient.queryAsync(PAYMENTS_PATH, sdkAuthorization(), queryFilter, PaymentsQueryResponse.class);
    }

    @Override
    public CompletableFuture<GetPaymentResponse> getPayment(final String paymentId) {
        validateParams("paymentId", paymentId);
        return apiClient.getAsync(buildPath(PAYMENTS_PATH, paymentId), sdkAuthorization(), GetPaymentResponse.class);
    }

    @Override
    public CompletableFuture<ItemsResponse<PaymentAction>> getPaymentActions(final String paymentId) {
        validateParams("paymentId", paymentId);
        return apiClient.getAsync(buildPath(PAYMENTS_PATH, paymentId, ACTIONS_PATH), sdkAuthorization(), PAYMENT_ACTIONS_TYPE);
    }

    @Override
    public CompletableFuture<CaptureResponse> capturePayment(final String paymentId) {
        validateParams("paymentId", paymentId);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, CAPTURES_PATH), sdkAuthorization(), CaptureResponse.class, null, null);
    }

    @Override
    public CompletableFuture<CaptureResponse> capturePayment(final String paymentId, final String idempotencyKey) {
        validateParams("paymentId", paymentId, "idempotencyKey", idempotencyKey);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, CAPTURES_PATH), sdkAuthorization(), CaptureResponse.class, null, idempotencyKey);
    }

    @Override
    public CompletableFuture<CaptureResponse> capturePayment(final String paymentId, final CaptureRequest captureRequest) {
        validateParams("paymentId", paymentId, "captureRequest", captureRequest);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, CAPTURES_PATH), sdkAuthorization(), CaptureResponse.class, captureRequest, null);
    }

    @Override
    public CompletableFuture<CaptureResponse> capturePayment(final String paymentId, final CaptureRequest captureRequest, final String idempotencyKey) {
        validateParams("paymentId", paymentId, "captureRequest", captureRequest, "idempotencyKey", idempotencyKey);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, CAPTURES_PATH), sdkAuthorization(), CaptureResponse.class, captureRequest, idempotencyKey);
    }

    @Override
    public CompletableFuture<RefundResponse> refundPayment(final String paymentId) {
        validateParams("paymentId", paymentId);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, REFUNDS_PATH), sdkAuthorization(), RefundResponse.class, null, null);
    }

    @Override
    public CompletableFuture<RefundResponse> refundPayment(final String paymentId, final String idempotencyKey) {
        validateParams("paymentId", paymentId, "idempotencyKey", idempotencyKey);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, REFUNDS_PATH), sdkAuthorization(), RefundResponse.class, null, idempotencyKey);
    }

    @Override
    public CompletableFuture<RefundResponse> refundPayment(final String paymentId, final RefundRequest refundRequest) {
        validateParams("paymentId", paymentId, "refundRequest", refundRequest);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, REFUNDS_PATH), sdkAuthorization(), RefundResponse.class, refundRequest, null);
    }

    @Override
    public CompletableFuture<RefundResponse> refundPayment(final String paymentId, final RefundRequest refundRequest, final String idempotencyKey) {
        validateParams("paymentId", paymentId, "refundRequest", refundRequest, "idempotencyKey", idempotencyKey);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, REFUNDS_PATH), sdkAuthorization(), RefundResponse.class, refundRequest, idempotencyKey);
    }

    @Override
    public CompletableFuture<VoidResponse> voidPayment(final String paymentId) {
        validateParams("paymentId", paymentId);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, VOIDS_PATH), sdkAuthorization(), VoidResponse.class, null, null);
    }

    @Override
    public CompletableFuture<VoidResponse> voidPayment(final String paymentId, final String idempotencyKey) {
        validateParams("paymentId", paymentId, "idempotencyKey", idempotencyKey);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, VOIDS_PATH), sdkAuthorization(), VoidResponse.class, null, idempotencyKey);
    }

    @Override
    public CompletableFuture<VoidResponse> voidPayment(final String paymentId, final VoidRequest voidRequest) {
        validateParams("paymentId", paymentId, "voidRequest", voidRequest);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, VOIDS_PATH), sdkAuthorization(), VoidResponse.class, voidRequest, null);
    }

    @Override
    public CompletableFuture<VoidResponse> voidPayment(final String paymentId, final VoidRequest voidRequest, final String idempotencyKey) {
        validateParams("paymentId", paymentId, "voidRequest", voidRequest, "idempotencyKey", idempotencyKey);
        return apiClient.postAsync(buildPath(PAYMENTS_PATH, paymentId, VOIDS_PATH), sdkAuthorization(), VoidResponse.class, voidRequest, idempotencyKey);
    }

}
