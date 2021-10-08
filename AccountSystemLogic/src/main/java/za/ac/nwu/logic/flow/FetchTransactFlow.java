package za.ac.nwu.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.TransactionDto;

import java.util.List;

public interface FetchTransactFlow {

    List<TransactionDto> getAllTransactions();

}
