package com.interview.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.interview.demo.dto.CreditNoteBillResponseDto;
import com.interview.demo.entity.CreditNote;

@Repository
public interface CreditNoteRepository extends JpaRepository<CreditNote, UUID> {

	@Query(value = "SELECT t.id as creditNoteId, t.note_type as noteType, t.destination_plant as destinationPlant, t.description as description, t.party_name as partyName, t.note_date as noteDate, t.note_quantity as noteQuantity, t.total_tcs_percent as totalTcsPercentage, t.bill_quantity as billQuantity, t.company_name as companyName, t.note_number as noteNumber, t.bill_type as billType, t.total_gross_amount as totalGrossAmount, t.total_tcs_amount as totalTcsAmount, s.id as billId, s.bill_number as billNumber, s.bill_date as billDate FROM credit_note t "
			+ "INNER JOIN bills s ON t.id = s.credit_note_id WHERE s.bill_number = :billNumberParam", nativeQuery = true)
	List<CreditNoteBillResponseDto> findByCriteria(@Param("billNumberParam") String billNumber);

}
