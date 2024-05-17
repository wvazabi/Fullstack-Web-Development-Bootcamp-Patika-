package dev.patika.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingUpdateRequest {
    private Long id;
    private String borrowerName;
    private LocalDate borrowingDate;
    private LocalDate returnDate;


}

