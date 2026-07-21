package com.jumpserver.sdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;


public class ChangeSecretAutomationRequest {


    @JSONField(name = "id")
    private String id;



    @JSONField(name = "name")
    private String name;
    @JSONField(name = "accounts")
    private List<String> accounts;
    @JSONField(name = "assets")
    private List<String> assets;
    @JSONField(name = "nodes")
    private List<String> nodes;
    @JSONField(name = "secret_strategy")
    private String secretStrategy;
    @JSONField(name = "secret_type")
    private String secretType;
    @JSONField(name = "secret")
    private String secret;
    @JSONField(name = "password_rules")
    private PasswordRulesDTO passwordRules;
    @JSONField(name = "ssh_key_change_strategy")
    private String sshKeyChangeStrategy;
    @JSONField(name = "params")
    private ParamsDTO params;
    @JSONField(name = "is_periodic")
    private Boolean isPeriodic;
    @JSONField(name = "crontab")
    private Object crontab;
    @JSONField(name = "interval")
    private Integer interval;
    @JSONField(name = "is_active")
    private Boolean isActive;
    @JSONField(name = "recipients")
    private List<?> recipients;
    @JSONField(name = "comment")
    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }

    public List<?> getAssets() {
        return assets;
    }

    public void setAssets(List<String> assets) {
        this.assets = assets;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public String getSecretStrategy() {
        return secretStrategy;
    }

    public void setSecretStrategy(String secretStrategy) {
        this.secretStrategy = secretStrategy;
    }

    public String getSecretType() {
        return secretType;
    }

    public void setSecretType(String secretType) {
        this.secretType = secretType;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public PasswordRulesDTO getPasswordRules() {
        return passwordRules;
    }

    public void setPasswordRules(PasswordRulesDTO passwordRules) {
        this.passwordRules = passwordRules;
    }

    public String getSshKeyChangeStrategy() {
        return sshKeyChangeStrategy;
    }

    public void setSshKeyChangeStrategy(String sshKeyChangeStrategy) {
        this.sshKeyChangeStrategy = sshKeyChangeStrategy;
    }

    public ParamsDTO getParams() {
        return params;
    }

    public void setParams(ParamsDTO params) {
        this.params = params;
    }

    public Boolean getIsPeriodic() {
        return isPeriodic;
    }

    public void setIsPeriodic(Boolean isPeriodic) {
        this.isPeriodic = isPeriodic;
    }

    public Object getCrontab() {
        return crontab;
    }

    public void setCrontab(Object crontab) {
        this.crontab = crontab;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public List<?> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<?> recipients) {
        this.recipients = recipients;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public static class ParamsDTO {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
