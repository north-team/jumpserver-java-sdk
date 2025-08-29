package com.jumpserver.sdk.model.account;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;


public class ChangeSecretAutomationsRequest {


    @JSONField(name = "id")
    private String id;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "interval")
    private Integer interval;
    @JSONField(name = "crontab")
    private String crontab;
    @JSONField(name = "comment")
    private String comment;
    @JSONField(name = "accounts")
    private AccountsDTO accounts;
    @JSONField(name = "nodes")
    private List<String> nodes;
    @JSONField(name = "assets")
    private List<String> assets;
    @JSONField(name = "secret_type")
    private SecretTypeDTO secretType;
    @JSONField(name = "secret_strategy")
    private SecretStrategyDTO secretStrategy;
    @JSONField(name = "secret")
    private String secret;
    @JSONField(name = "password_rules")
    private PasswordRulesDTO passwordRules;
    @JSONField(name = "ssh_key_change_strategy")
    private SshKeyChangeStrategyDTO sshKeyChangeStrategy;
    @JSONField(name = "passphrase")
    private String passphrase;
    @JSONField(name = "recipients")
    private List<String> recipients;
    @JSONField(name = "params")
    private ParamsDTO params;
    @JSONField(name = "is_periodic")
    private Boolean isPeriodic;
    @JSONField(name = "is_active")
    private Boolean isActive;


    public static class AccountsDTO {
    }

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

    public String getCrontab() {
        return crontab;
    }

    public void setCrontab(String crontab) {
        this.crontab = crontab;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public AccountsDTO getAccounts() {
        return accounts;
    }

    public void setAccounts(AccountsDTO accounts) {
        this.accounts = accounts;
    }

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public List<String> getAssets() {
        return assets;
    }

    public void setAssets(List<String> assets) {
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

    public SshKeyChangeStrategyDTO getSshKeyChangeStrategy() {
        return sshKeyChangeStrategy;
    }

    public void setSshKeyChangeStrategy(SshKeyChangeStrategyDTO sshKeyChangeStrategy) {
        this.sshKeyChangeStrategy = sshKeyChangeStrategy;
    }

    public String getPassphrase() {
        return passphrase;
    }

    public void setPassphrase(String passphrase) {
        this.passphrase = passphrase;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    public ParamsDTO getParams() {
        return params;
    }

    public void setParams(ParamsDTO params) {
        this.params = params;
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
