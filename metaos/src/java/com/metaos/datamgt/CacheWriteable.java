/*
 * Copyright 2011 - 2012
 * All rights reserved. License and terms according to LICENSE.txt file.
 * The LICENSE.txt file and this header must be included or referenced 
 * in each piece of code derived from this project.
 */
package com.metaos.datamgt;

import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * Writeable side for a cache of market prices.
 */
public interface CacheWriteable {
    /**
     * Sets center price for a given moment.
     */
    public void setPrice(final Calendar when, final String what,
            final double how);

    /**
     * Sets BID price for a given moment.
     */
    public void setBid(final Calendar when,final String what,final double how);

    /**
     * Sets ASK price for a given moment.
     */
    public void setAsk(final Calendar when,final String what,final double how);
}
