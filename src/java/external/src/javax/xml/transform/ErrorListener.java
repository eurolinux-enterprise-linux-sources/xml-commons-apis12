/*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javax.xml.transform;

/**
 * <p>To provide customized error handling, implement this interface and
 * use the setErrorListener method to register an instance of the implmentation
 * with the {@link javax.xml.transform.Transformer}. The Transformer then reports
 * all errors and warnings through this interface.</p>
 *
 * <p>If an application does <em>not</em>
 * register an ErrorListener, errors are reported to System.err.</p>
 *
 * <p>For transformation errors, a Transformer must use this interface
 * instead of throwing an exception: it is up to the application
 * to decide whether to throw an exception for different types of
 * errors and warnings.  Note however that the Transformer is not required
 * to continue with the transformation after a call to fatalError.</p>
 *
 * <p>Transformers may use this mechanism to report XML parsing errors
 * as well as transformation errors.</p>
 */
public interface ErrorListener {

    /**
     * Receive notification of a warning.
     *
     * <p>{@link javax.xml.transform.Transformer} can use this method to report
     * conditions that are not errors or fatal errors.  The default behaviour
     * is to take no action.</p>
     *
     * <p>After invoking this method, the Transformer must continue with
     * the transformation. It should still be possible for the
     * application to process the document through to the end.</p>
     *
     * @param exception The warning information encapsulated in a
     *                  transformer exception.
     *
     * @throws javax.xml.transform.TransformerException if the application
     * chooses to discontinue the transformation.
     *
     * @see javax.xml.transform.TransformerException
     */
    public abstract void warning(TransformerException exception)
        throws TransformerException;

    /**
     * Receive notification of a recoverable error.
     *
     * <p>The transformer must continue to try and provide normal transformation
     * after invoking this method.  It should still be possible for the
     * application to process the document through to the end if no other errors
     * are encountered.</p>
     *
     * @param exception The error information encapsulated in a
     *                  transformer exception.
     *
     * @throws javax.xml.transform.TransformerException if the application
     * chooses to discontinue the transformation.
     *
     * @see javax.xml.transform.TransformerException
     */
    public abstract void error(TransformerException exception)
        throws TransformerException;

    /**
     * Receive notification of a non-recoverable error.
     *
     * <p>The transformer must continue to try and provide normal transformation
     * after invoking this method.  It should still be possible for the
     * application to process the document through to the end if no other errors
     * are encountered, but there is no guarantee that the output will be
     * useable.</p>
     *
     * @param exception The error information encapsulated in a
     *                  transformer exception.
     *
     * @throws javax.xml.transform.TransformerException if the application
     * chooses to discontinue the transformation.
     *
     * @see javax.xml.transform.TransformerException
     */
    public abstract void fatalError(TransformerException exception)
        throws TransformerException;
}
