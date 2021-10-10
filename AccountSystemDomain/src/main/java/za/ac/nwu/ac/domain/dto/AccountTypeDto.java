package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "A DTO that represents the AccountType")

public class AccountTypeDto implements Serializable {

    private static final long serialVersionUID = -7731154715176897719L;

    private Long ACCOUNT_TYPE_ID;
    private String MNEMONIC;
    private String ACCOUNT_TYPE_NAME;
    private LocalDate CREATION_DATE;

    public AccountTypeDto() {
    }

    /*public AccountTypeDto(String MNEMONIC, String ACCOUNT_TYPE_NAME, LocalDate CREATION_DATE) {
        this.MNEMONIC = MNEMONIC;
        this.ACCOUNT_TYPE_NAME = ACCOUNT_TYPE_NAME;
        this.CREATION_DATE = CREATION_DATE;
    }*/

    public AccountTypeDto(AccountType accountType){
        this.setAccountTypeID(accountType.getAccountTypeId());
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setMnemonic(accountType.getMnemonic());
        this.setCreationDate(accountType.getCreationDate());
    }

    @ApiModelProperty(position = 1,
            value = "AccountType ID",
            name = "ID",
            notes = "Uniquely identify the account type by Id",
            dataType = "java.lang.String",
            example = "100689",
            required = true)
    public Long getAccountTypeID() {
        return ACCOUNT_TYPE_ID;
    }

    public void setAccountTypeID(Long ACCOUNT_TYPE_ID) {
        this.ACCOUNT_TYPE_ID = ACCOUNT_TYPE_ID;
    }

    @ApiModelProperty(position = 2,
    value = "AccountType Mnemonic",
    name = "mnemonic",
    notes = "Uniquely identify the account type",
    dataType = "java.lang.String",
    example = "MILES",
    required = true)
    public String getMnemonic() {
        return MNEMONIC;
    }
    public void setMnemonic(String MNEMONIC) {
        this.MNEMONIC = MNEMONIC;
    }

    @ApiModelProperty(position = 3,
            value = "AccountType accountTypeName",
            name = "accountTypeName",
            notes = "AccountType Name",
            dataType = "java.lang.String",
            example = "Miles",
            allowEmptyValue = false,
            required = true)
    public String getAccountTypeName() {
        return ACCOUNT_TYPE_NAME;
    }
    public void setAccountTypeName(String ACCOUNT_TYPE_NAME) {
        this.ACCOUNT_TYPE_NAME = ACCOUNT_TYPE_NAME;
    }

    @ApiModelProperty(position = 4,
            value = "AccountType creationDate",
            name = "creationDate",
            notes = "Creation Date of the account",
            dataType = "java.lang.String",
            example = "2021-05-09",
            allowEmptyValue = true,
            required = false)
    public LocalDate getCreationDate() {
        return CREATION_DATE;
    }
    public void setCreationDate(LocalDate CREATION_DATE) {
        this.CREATION_DATE = CREATION_DATE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(MNEMONIC, that.MNEMONIC) && Objects.equals(ACCOUNT_TYPE_NAME, that.ACCOUNT_TYPE_NAME) && Objects.equals(CREATION_DATE, that.CREATION_DATE);
    }

   @JsonIgnore
    public AccountType getAccountType(){
        return new AccountType(getAccountTypeID(), getMnemonic(), getAccountTypeName(), getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(MNEMONIC, ACCOUNT_TYPE_NAME, CREATION_DATE);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "mnemonic='" + MNEMONIC + '\'' +
                ", accountTypeName='" + ACCOUNT_TYPE_NAME + '\'' +
                ", creationDate=" + CREATION_DATE +
                '}';
    }
}
