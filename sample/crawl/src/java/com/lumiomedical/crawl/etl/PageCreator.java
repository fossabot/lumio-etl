package com.lumiomedical.crawl.etl;

import com.lumiomedical.crawl.data.Page;
import com.lumiomedical.flow.actor.transformer.TransformationException;
import com.lumiomedical.flow.actor.transformer.Transformer;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author Pierre Lecerf (plecerf@lumiomedical.com)
 * Created on 2020/12/24
 */
public class PageCreator implements Transformer<InputStream, Page>
{
    private final Charset charset;

    public PageCreator(Charset charset)
    {
        this.charset = charset;
    }

    public PageCreator()
    {
        this(Charset.defaultCharset());
    }

    @Override
    public Page transform(InputStream input) throws TransformationException
    {
        return null;
    }
}
