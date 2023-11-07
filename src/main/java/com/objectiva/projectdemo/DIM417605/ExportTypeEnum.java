package com.objectiva.projectdemo.DIM417605;

import java.util.Optional;

/**
 * The Enum ExportTypeEnum.
 */
public enum ExportTypeEnum {

    /**
     * The payroll.
     */
    PAYROLL("Payroll"),
    /**
     * The accrual.
     */
    ACCRUAL("Accrual"),
    /**
     * The both.
     */
    BOTH("Both");

    /**
     * The value.
     */
    private String value;

    /**
     * Instantiates a new export type enum.
     *
     * @param value the value
     */
    private ExportTypeEnum(String value) {
        this.value = value;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return value;
    }

    /**
     * Resolve.
     *
     * @param input the input
     * @return the optional
     */
    public static Optional<ExportTypeEnum> resolve(String input) {
        for (ExportTypeEnum et : ExportTypeEnum.values()) {
            if (et.toString().equalsIgnoreCase(input.trim()))
                return Optional.of(et);
        }
        return Optional.empty();
    }
}

