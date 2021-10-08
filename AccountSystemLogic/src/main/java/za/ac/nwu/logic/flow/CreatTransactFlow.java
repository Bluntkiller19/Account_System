package za.ac.nwu.logic.flow;

import za.ac.nwu.ac.domain.dto.TransactionDto;

public interface CreatTransactFlow {
    TransactionDto create(TransactionDto transaction);
}
