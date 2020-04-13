/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : StreamClosedHttpResponse
 * Date Created : 2020-03-05
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-05       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.utils;

import java.io.IOException;
import java.util.Locale;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.params.HttpParams;

/**
 * @program: com.example.lishuiduijie_test.utils
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-05
 **/

@SuppressWarnings("deprecation")
public class StreamClosedHttpResponse implements HttpResponse
{
    private final HttpResponse original;

    private final String content;

    public StreamClosedHttpResponse(final HttpResponse original)
            throws UnsupportedOperationException, IOException
    {
        this.original = original;

        HttpEntity entity = original.getEntity();
        if (entity != null && entity.isStreaming())
        {
            String encoding = entity.getContentEncoding() != null
                    ? entity.getContentEncoding().getValue() : null;
            content = StreamUtil.inputStream2String(entity.getContent(),
                    encoding);
        }
        else
        {
            content = null;
        }
    }

    @Override
    public StatusLine getStatusLine()
    {
        return original.getStatusLine();
    }

    @Override
    public void setStatusLine(final StatusLine statusline)
    {
        original.setStatusLine(statusline);
    }

    @Override
    public void setStatusLine(final ProtocolVersion ver, final int code)
    {
        original.setStatusLine(ver, code);
    }

    @Override
    public void setStatusLine(final ProtocolVersion ver, final int code,
                              final String reason)
    {
        original.setStatusLine(ver, code, reason);
    }

    @Override
    public void setStatusCode(final int code) throws IllegalStateException
    {
        original.setStatusCode(code);
    }

    @Override
    public void setReasonPhrase(final String reason)
            throws IllegalStateException
    {
        original.setReasonPhrase(reason);
    }

    @Override
    public HttpEntity getEntity()
    {
        return original.getEntity();
    }

    @Override
    public void setEntity(final HttpEntity entity)
    {
        original.setEntity(entity);
    }

    @Override
    public Locale getLocale()
    {
        return original.getLocale();
    }

    @Override
    public void setLocale(final Locale loc)
    {
        original.setLocale(loc);
    }

    @Override
    public ProtocolVersion getProtocolVersion()
    {
        return original.getProtocolVersion();
    }

    @Override
    public boolean containsHeader(final String name)
    {
        return original.containsHeader(name);
    }

    @Override
    public Header[] getHeaders(final String name)
    {
        return original.getHeaders(name);
    }

    @Override
    public Header getFirstHeader(final String name)
    {
        return original.getFirstHeader(name);
    }

    @Override
    public Header getLastHeader(final String name)
    {
        return original.getLastHeader(name);
    }

    @Override
    public Header[] getAllHeaders()
    {
        return original.getAllHeaders();
    }

    @Override
    public void addHeader(final Header header)
    {
        original.addHeader(header);
    }

    @Override
    public void addHeader(final String name, final String value)
    {
        original.addHeader(name, value);
    }

    @Override
    public void setHeader(final Header header)
    {
        original.setHeader(header);
    }

    @Override
    public void setHeader(final String name, final String value)
    {
        original.setHeader(name, value);
    }

    @Override
    public void setHeaders(final Header[] headers)
    {
        original.setHeaders(headers);
    }

    @Override
    public void removeHeader(final Header header)
    {
        original.removeHeader(header);
    }

    @Override
    public void removeHeaders(final String name)
    {
        original.removeHeaders(name);
    }

    @Override
    public HeaderIterator headerIterator()
    {
        return original.headerIterator();
    }

    @Override
    public HeaderIterator headerIterator(final String name)
    {
        return original.headerIterator(name);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("HttpResponseProxy{");
        sb.append(original);
        sb.append('}');
        return sb.toString();
    }

    @Override
    @Deprecated
    public HttpParams getParams()
    {
        return original.getParams();
    }

    @Override
    @Deprecated
    public void setParams(final HttpParams params)
    {
        original.setParams(params);
    }

    public String getContent()
    {
        return content;
    }
}