/**
 * Copyright © The Boots Company PLC. All rights reserved.
 */
package com.davies.group.exceptions;

import org.openqa.selenium.TimeoutException;

/**
 * Exception to be thrown when {@link org.openqa.selenium.WebElement} is Enabled
 */
public class ElementEnabledException extends TimeoutException {

    /**
     * Exception
     *
     * @param error to be thrown
     */
    public ElementEnabledException(String error) {
        super(error);
    }

    /**
     * Exception
     *
     * @param error to be throw
     * @param cause {@link Throwable} cause
     */
    public ElementEnabledException(String error, Throwable cause) {
        super(error, cause);
    }


}
