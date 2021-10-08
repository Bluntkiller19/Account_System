package za.ac.nwu.ac.domain.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransact", description = "A DTO that represents the Transactions")
public class TransactionDto implements Serializable {

    private static final long serialVersionUID = 3766497939333573388L;

    private AccountType ACCOUNT_TYPE_ID;
    private Long MEMBER_ID;
    private Long AMOUNT;
    private LocalDate TX_DATE;

    public TransactionDto() {
    }

    public TransactionDto(AccountTransaction accountTransaction) {
    }

    public TransactionDto(AccountType ACCOUNT_TYPE_ID, Long MEMBER_ID, Long AMOUNT, LocalDate TX_DATE) {
        this.ACCOUNT_TYPE_ID = ACCOUNT_TYPE_ID;
        this.MEMBER_ID = MEMBER_ID;
        this.AMOUNT = AMOUNT;
        this.TX_DATE = TX_DATE;
    }

    @ApiModelProperty(position = 1,
            value = "Transaction ID",
            name = "Transaction_ID",
            notes = "Uniquely identify the Transaction by account type ID",
            dataType = "java.lang.String",
            example = "5555",
            required = true)
    public AccountType getAccountTypeId() {
        return ACCOUNT_TYPE_ID;
    }
    public void setAccountTypeId(AccountType ACCOUNT_TYPE_ID) {
        this.ACCOUNT_TYPE_ID = ACCOUNT_TYPE_ID;
    }


    @ApiModelProperty(position = 2,
            value = "Member ID",
            name = "Member_ID",
            notes = "Uniquely identify the Transaction by account member ID",
            dataType = "java.lang.String",
            example = "988975143",
            required = true)
    public Long getMemberId() {
        return MEMBER_ID;
    }
    public void setMemberId(Long MEMBER_ID) {
        this.MEMBER_ID = MEMBER_ID;
    }


    @ApiModelProperty(position = 3,
            value = "Transaction amount",
            name = "amount",
            notes = "amount worth of transaction",
            dataType = "java.lang.String",
            example = "500",
            required = true)
    public Long getAmount() {
        return AMOUNT;
    }
    public void setAmount(Long AMOUNT) {
        AMOUNT = AMOUNT;
    }

    @ApiModelProperty(position = 4,
            value = "transaction creationDate",
            name = "TX_Date",
            notes = "Creation Date of the transaction",
            dataType = "java.lang.String",
            example = "2021-05-09",
            allowEmptyValue = true,
            required = false)
    public LocalDate getTxDate() {
        return TX_DATE;
    }
    public void setTxDate(LocalDate TX_DATE) {
        this.TX_DATE = TX_DATE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDto that = (TransactionDto) o;
        return MEMBER_ID == that.MEMBER_ID && AMOUNT == that.AMOUNT && Objects.equals(ACCOUNT_TYPE_ID, that.ACCOUNT_TYPE_ID) && Objects.equals(TX_DATE, that.TX_DATE);
    }
    @JsonIgnore
    public AccountTransaction getTransaction(){
        return new AccountTransaction(getAccountTypeId(), getMemberId(), getAmount(), getTxDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ACCOUNT_TYPE_ID, MEMBER_ID, AMOUNT, TX_DATE);
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "ACCOUNT_TYPE_ID=" + ACCOUNT_TYPE_ID +
                ", MEMBER_ID=" + MEMBER_ID +
                ", AMOUNT=" + AMOUNT +
                ", TX_DATE=" + TX_DATE +
                '}';
    }
}
