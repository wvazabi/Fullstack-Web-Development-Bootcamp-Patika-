package dev.patika.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowingResponse {
    private Long id;
    private String borrowerName;
    private LocalDate borrowingDate;
    private LocalDate returnDate;


}

