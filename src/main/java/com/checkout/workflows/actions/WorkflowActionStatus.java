package com.checkout.workflows.actions;

import com.google.gson.annotations.SerializedName;

public enum WorkflowActionStatus {

    @SerializedName("pending")
    PENDING,
    @SerializedName("successful")
    SUCCESSFUL,
    @SerializedName("failed")
    FAILED
}
