package com.checkout.customers.previous;

import com.checkout.AbstractClient;
import com.checkout.ApiClient;
import com.checkout.CheckoutConfiguration;
import com.checkout.EmptyResponse;
import com.checkout.SdkAuthorizationType;
import com.checkout.common.IdResponse;

import java.util.concurrent.CompletableFuture;

import static com.checkout.common.CheckoutUtils.validateParams;

public class CustomersClientImpl extends AbstractClient implements CustomersClient {

    private static final String CUSTOMERS_PATH = "customers";

    public CustomersClientImpl(final ApiClient apiClient, final CheckoutConfiguration configuration) {
        super(apiClient, configuration, SdkAuthorizationType.SECRET_KEY);
    }

    @Override
    public CompletableFuture<CustomerDetailsResponse> get(final String customerId) {
        validateParams("customerId", customerId);
        return apiClient.getAsync(buildPath(CUSTOMERS_PATH, customerId), sdkAuthorization(), CustomerDetailsResponse.class);
    }

    @Override
    public CompletableFuture<IdResponse> create(final CustomerRequest customerRequest) {
        validateParams("customerRequest", customerRequest);
        return apiClient.postAsync(CUSTOMERS_PATH, sdkAuthorization(), IdResponse.class, customerRequest, null);
    }

    @Override
    public CompletableFuture<EmptyResponse> update(final String customerId, final CustomerRequest customerRequest) {
        validateParams("customerId", customerId, "customerRequest", customerRequest);
        return apiClient.patchAsync(buildPath(CUSTOMERS_PATH, customerId), sdkAuthorization(), EmptyResponse.class, customerRequest, null);
    }

    @Override
    public CompletableFuture<EmptyResponse> delete(final String customerId) {
        validateParams("customerId", customerId);
        return apiClient.deleteAsync(buildPath(CUSTOMERS_PATH, customerId), sdkAuthorization());
    }

}
