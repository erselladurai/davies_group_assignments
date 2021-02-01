/**
 * Copyright © The Boots Company PLC. All rights reserved.
 */
package com.davies.group.exceptions;

import org.openqa.selenium.TimeoutException;

/**
 * Exception to be thrown when {@link org.openqa.selenium.WebElement} is Visible
 */
public class ElementVisibleException extends TimeoutException {

    /**
     * Exception
     *
     * @param error to be throw
     */
    public ElementVisibleException(String error) {
        super(error);
    }

    /**
     * Exception
     *
     * @param error to be throw
     * @param cause {@link Throwable} cause
     */
    public ElementVisibleException(String error, Throwable cause) {
        super(error, cause);
    }


}
