package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.TransactionDto;

import java.util.List;

public interface TransactTranslator {

    List<TransactionDto> getAllTransactions();

    TransactionDto create(TransactionDto transaction);
}
