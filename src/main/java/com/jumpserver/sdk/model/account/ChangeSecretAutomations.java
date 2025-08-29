package com.jumpserver.sdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;


public class ChangeSecretAutomations {

    @JSONField(name = "created_by")
    private String createdBy;
    @JSONField(name = "periodic_display")
    private String periodicDisplay;
    @JSONField(name = "executed_amount")
    private Integer executedAmount;
    @JSONField(name = "id")
    private String id;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "interval")
    private Integer interval;
    @JSONField(name = "crontab")
    private Object crontab;
    @JSONField(name = "comment")
    private String comment;
    @JSONField(name = "type")
    private String type;
    @JSONField(name = "accounts")
    private List<String> accounts;
    @JSONField(name = "nodes")
    private List<?> nodes;
    @JSONField(name = "assets")
    private List<?> assets;
    @JSONField(name = "secret_type")
    private SecretTypeDTO secretType;
    @JSONField(name = "secret_strategy")
    private SecretStrategyDTO secretStrategy;
    @JSONField(name = "password_rules")
    private PasswordRulesDTO passwordRules;
    @JSONField(name = "ssh_key_change_strategy")
    private SshKeyChangeStrategyDTO sshKeyChangeStrategy;
    @JSONField(name = "recipients")
    private List<?> recipients;
    @JSONField(name = "params")
    private ParamsDTO params;
    @JSONField(name = "org_id")
    private String orgId;
    @JSONField(name = "org_name")
    private String orgName;
    @JSONField(name = "is_periodic")
    private Boolean isPeriodic;
    @JSONField(name = "is_active")
    private Boolean isActive;
    @JSONField(name = "date_created")
    private String dateCreated;
    @JSONField(name = "date_updated")
    private String dateUpdated;


    public static class SecretTypeDTO {
        @JSONField(name = "value")
        private String value;
        @JSONField(name = "label")
        private String label;

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
        private String value;
        @JSONField(name = "label")
        private String label;

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
        private Integer length;
        @JSONField(name = "lowercase")
        private Boolean lowercase;
        @JSONField(name = "uppercase")
        private Boolean uppercase;
        @JSONField(name = "digit")
        private Boolean digit;
        @JSONField(name = "symbol")
        private Boolean symbol;
        @JSONField(name = "exclude_symbols")
        private String excludeSymbols;

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
        private String value;
        @JSONField(name = "label")
        private String label;

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
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getPeriodicDisplay() {
        return periodicDisplay;
    }

    public void setPeriodicDisplay(String periodicDisplay) {
        this.periodicDisplay = periodicDisplay;
    }

    public Integer getExecutedAmount() {
        return executedAmount;
    }

    public void setExecutedAmount(Integer executedAmount) {
        this.executedAmount = executedAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Object getCrontab() {
        return crontab;
    }

    public void setCrontab(Object crontab) {
        this.crontab = crontab;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }

    public List<?> getNodes() {
        return nodes;
    }

    public void setNodes(List<?> nodes) {
        this.nodes = nodes;
    }

    public List<?> getAssets() {
        return assets;
    }

    public void setAssets(List<?> assets) {
        this.assets = assets;
    }

    public SecretTypeDTO getSecretType() {
        return secretType;
    }

    public void setSecretType(SecretTypeDTO secretType) {
        this.secretType = secretType;
    }

    public SecretStrategyDTO getSecretStrategy() {
        return secretStrategy;
    }

    public void setSecretStrategy(SecretStrategyDTO secretStrategy) {
        this.secretStrategy = secretStrategy;
    }

    public PasswordRulesDTO getPasswordRules() {
        return passwordRules;
    }

    public void setPasswordRules(PasswordRulesDTO passwordRules) {
        this.passwordRules = passwordRules;
    }

    public SshKeyChangeStrategyDTO getSshKeyChangeStrategy() {
        return sshKeyChangeStrategy;
    }

    public void setSshKeyChangeStrategy(SshKeyChangeStrategyDTO sshKeyChangeStrategy) {
        this.sshKeyChangeStrategy = sshKeyChangeStrategy;
    }

    public List<?> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<?> recipients) {
        this.recipients = recipients;
    }

    public ParamsDTO getParams() {
        return params;
    }

    public void setParams(ParamsDTO params) {
        this.params = params;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Boolean getPeriodic() {
        return isPeriodic;
    }

    public void setPeriodic(Boolean periodic) {
        isPeriodic = periodic;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }
}
