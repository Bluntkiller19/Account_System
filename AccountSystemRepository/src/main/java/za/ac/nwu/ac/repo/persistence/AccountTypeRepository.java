package za.ac.nwu.ac.repo.persistence;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {


    @Query(value = "SELECT " +
            "ACCOUNT_TYPE_ID, " +
            "ACCOUNT_TYPE_NAME, " +
            "CREATION_DATE, " +
            "MNEMONIC" +
            "FROM  " +
            "C##.ACCOUNT_TYPE " +
            "WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);
}
