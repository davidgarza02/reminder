package com.bill.remind.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.LocalDate;

@Getter
@Setter
public class BillDTO {
    private JsonNullable<String> name = JsonNullable.undefined();
    private JsonNullable<Double> amount = JsonNullable.undefined();
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
    private JsonNullable<LocalDate> dueDate = JsonNullable.undefined();
    private JsonNullable<Integer> repeat = JsonNullable.undefined();
    private JsonNullable<String> notes = JsonNullable.undefined();
    private JsonNullable<Boolean> isDeleted = JsonNullable.undefined();

    protected BillDTO() { }
}
