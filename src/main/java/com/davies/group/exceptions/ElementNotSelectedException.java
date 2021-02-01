/**
 * Copyright © The Boots Company PLC. All rights reserved.
 */
package com.davies.group.exceptions;

import org.openqa.selenium.TimeoutException;

/**
 * Exception to be thrown when {@link org.openqa.selenium.WebElement} is Not Present
 */
public class ElementNotSelectedException extends TimeoutException {

    /**
     * Exception
     *
     * @param error to be throw
     */
    public ElementNotSelectedException(String error) {
        super(error);
    }

    /**
     * Exception
     *
     * @param error to be throw
     * @param cause {@link Throwable} cause
     */
    public ElementNotSelectedException(String error, Throwable cause) {
        super(error, cause);
    }


}
