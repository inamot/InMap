// $Id$
// Copyright (c) 1996-2007 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.ocl;

import org.tigris.gef.ocl.ExpansionException;


/**
 * CriticOclEvaluator is singleton version of OCLEvaluator which is used for
 * evaluating simple OCL expressions used in the critiques.<p>
 * 
 * Implementation History: As best I was able to reconstruct the history in
 * early 2007, OclEvaluator was originally implemented as a singleton, but that
 * was changed in September, 2004 because of some perceived problems, but then
 * it was discovered that the Critic subsystem depended on the singleton
 * pattern, so an earlier version of OclEvaluator was reintroduced with a new
 * name. Because of the large amount of duplicate code between the two classes,
 * this was refactored in March, 2007 to use an instance of the main
 * OclEvaluator class.
 * 
 * @stereotype singleton
 * @deprecated for 0.25.2 by tfmorris - use {@link OCLEvaluator}
 */
public class CriticOclEvaluator {

    private static final CriticOclEvaluator INSTANCE =
        new CriticOclEvaluator();

    private static final OCLEvaluator EVALUATOR =
        new OCLEvaluator();
    
    private CriticOclEvaluator() {
        // no instantiations
    }

    /**
     * @return the singleton of CriticOclEvaluator
     */
    public static final CriticOclEvaluator getInstance() {
        return INSTANCE;
    }

    /*
     * @see OCLEvaluator#evalToString(java.lang.Object, java.lang.String)
     */
    public synchronized String evalToString(Object self, String expr)
        throws ExpansionException {
        
        return EVALUATOR.evalToString(self, expr);
    }

    /*
     * @see OCLEvaluator#evalToString(java.lang.Object, java.lang.String, java.lang.String)
     */
    public synchronized String evalToString(
            Object self,
            String expr,
            String sep)
    	throws ExpansionException {
        
        return EVALUATOR.evalToString(self, expr, sep);
    }

}