/**
 * Copyright © The Boots Company PLC. All rights reserved.
 */
package com.davies.group.exceptions;

import org.openqa.selenium.TimeoutException;

/**
 * Exception to be thrown when {@link org.openqa.selenium.WebElement} is Not Enabled
 */
public class ElementNotEnabledException extends TimeoutException {

    /**
     * Exception
     *
     * @param error to be throw
     */
    public ElementNotEnabledException(String error) {
        super(error);
    }

    /**
     * Exception
     *
     * @param error to be throw
     * @param cause {@link Throwable} cause
     */
    public ElementNotEnabledException(String error, Throwable cause) {
        super(error, cause);
    }


}
