package com.jumpserver.sdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;


public abstract class BaseChangeSecretAutomation {

    @JSONField(name = "id")
    protected String id;

    @JSONField(name = "name")
    protected String name;

    @JSONField(name = "interval")
    protected Integer interval;

    @JSONField(name = "crontab")
    protected Object crontab;

    @JSONField(name = "comment")
    protected String comment;

    @JSONField(name = "secret_type")
    protected SecretTypeDTO secretType;

    @JSONField(name = "secret_strategy")
    protected SecretStrategyDTO secretStrategy;

    @JSONField(name = "password_rules")
    protected PasswordRulesDTO passwordRules;

    @JSONField(name = "ssh_key_change_strategy")
    protected SshKeyChangeStrategyDTO sshKeyChangeStrategy;

    @JSONField(name = "recipients")
    protected List<?> recipients;

    @JSONField(name = "params")
    protected ParamsDTO params;

    @JSONField(name = "is_periodic")
    protected Boolean isPeriodic;

    @JSONField(name = "is_active")
    protected Boolean isActive;



    public static class SecretTypeDTO {
        @JSONField(name = "value")
        public String value;
        @JSONField(name = "label")
        public String label;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

    public static class SecretStrategyDTO {
        @JSONField(name = "value")
        public String value;
        @JSONField(name = "label")
        public String label;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

    public static class PasswordRulesDTO {
        @JSONField(name = "length")
        public Integer length;
        @JSONField(name = "lowercase")
        public Boolean lowercase;
        @JSONField(name = "uppercase")
        public Boolean uppercase;
        @JSONField(name = "digit")
        public Boolean digit;
        @JSONField(name = "symbol")
        public Boolean symbol;
        @JSONField(name = "exclude_symbols")
        public String excludeSymbols;

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }

        public Boolean getLowercase() {
            return lowercase;
        }

        public void setLowercase(Boolean lowercase) {
            this.lowercase = lowercase;
        }

        public Boolean getUppercase() {
            return uppercase;
        }

        public void setUppercase(Boolean uppercase) {
            this.uppercase = uppercase;
        }

        public Boolean getDigit() {
            return digit;
        }

        public void setDigit(Boolean digit) {
            this.digit = digit;
        }

        public Boolean getSymbol() {
            return symbol;
        }

        public void setSymbol(Boolean symbol) {
            this.symbol = symbol;
        }

        public String getExcludeSymbols() {
            return excludeSymbols;
        }

        public void setExcludeSymbols(String excludeSymbols) {
            this.excludeSymbols = excludeSymbols;
        }
    }

    public static class SshKeyChangeStrategyDTO {
        @JSONField(name = "value")
        public String value;
        @JSONField(name = "label")
        public String label;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

    public static class ParamsDTO {
        /* 按需补充 */
    }

    public static class AccountsDTO {
        /* 按需补充 */
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public void setCrontab(Object crontab) {
        this.crontab = crontab;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setSecretType(SecretTypeDTO secretType) {
        this.secretType = secretType;
    }

    public void setSecretStrategy(SecretStrategyDTO secretStrategy) {
        this.secretStrategy = secretStrategy;
    }

    public void setPasswordRules(PasswordRulesDTO passwordRules) {
        this.passwordRules = passwordRules;
    }

    public void setSshKeyChangeStrategy(SshKeyChangeStrategyDTO sshKeyChangeStrategy) {
        this.sshKeyChangeStrategy = sshKeyChangeStrategy;
    }

    public void setRecipients(List<?> recipients) {
        this.recipients = recipients;
    }

    public void setParams(ParamsDTO params) {
        this.params = params;
    }

    public void setPeriodic(Boolean periodic) {
        isPeriodic = periodic;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}