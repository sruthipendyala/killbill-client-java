/*
 * Copyright 2010-2013 Ning, Inc.
 * Copyright 2014 Groupon, Inc
 * Copyright 2014 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.killbill.billing.client.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.annotation.Nullable;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InvoicePaymentTransaction extends PaymentTransaction {

    private Boolean isAdjusted;
    private List<InvoiceItem> adjustments;

    public InvoicePaymentTransaction() {
    }

    @JsonCreator
    public InvoicePaymentTransaction(@JsonProperty("transactionId") final UUID transactionId,
                                     @JsonProperty("transactionExternalKey") final String transactionExternalKey,
                                     @JsonProperty("paymentId") final UUID paymentId,
                                     @JsonProperty("paymentExternalKey") final String paymentExternalKey,
                                     @JsonProperty("transactionType") final String transactionType,
                                     @JsonProperty("amount") final BigDecimal amount,
                                     @JsonProperty("currency") final String currency,
                                     @JsonProperty("effectiveDate") final DateTime effectiveDate,
                                     @JsonProperty("processedAmount") final BigDecimal processedAmount,
                                     @JsonProperty("processedCurrency") final String processedCurrency,
                                     @JsonProperty("status") final String status,
                                     @JsonProperty("gatewayErrorCode") final String gatewayErrorCode,
                                     @JsonProperty("gatewayErrorMsg") final String gatewayErrorMsg,
                                     @JsonProperty("firstPaymentReferenceId") final String firstPaymentReferenceId,
                                     @JsonProperty("secondPaymentReferenceId") final String secondPaymentReferenceId,
                                     @JsonProperty("properties") @Nullable final List<PluginProperty> properties,
                                     @JsonProperty("isAdjusted") final Boolean isAdjusted,
                                     @JsonProperty("adjustments") final List<InvoiceItem> adjustments,
                                     @JsonProperty("auditLogs") @Nullable final List<AuditLog> auditLogs) {
        super(transactionId, transactionExternalKey, paymentId, paymentExternalKey, transactionType, amount, currency, effectiveDate, processedAmount, processedCurrency,
              status, gatewayErrorCode, gatewayErrorMsg, firstPaymentReferenceId, secondPaymentReferenceId, properties, auditLogs);
        this.isAdjusted = isAdjusted;
        this.adjustments = adjustments;
    }

    public Boolean getIsAdjusted() {
        return isAdjusted;
    }

    public void setIsAdjusted(final Boolean isAdjusted) {
        this.isAdjusted = isAdjusted;
    }

    public List<InvoiceItem> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(final List<InvoiceItem> adjustments) {
        this.adjustments = adjustments;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InvoicePaymentTransaction)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        final InvoicePaymentTransaction that = (InvoicePaymentTransaction) o;

        if (adjustments != null ? !adjustments.equals(that.adjustments) : that.adjustments != null) {
            return false;
        }
        if (isAdjusted != null ? !isAdjusted.equals(that.isAdjusted) : that.isAdjusted != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isAdjusted != null ? isAdjusted.hashCode() : 0);
        result = 31 * result + (adjustments != null ? adjustments.hashCode() : 0);
        return result;
    }
}
