package com.lumiomedical.etl.transformer.tablesaw;

import com.lumiomedical.etl.dataframe.processor.CompositeProcessor;
import com.lumiomedical.etl.dataframe.processor.TableProcessor;
import com.lumiomedical.etl.dataframe.processor.TableProcessorException;
import com.lumiomedical.flow.actor.transformer.TransformationException;
import com.lumiomedical.flow.actor.transformer.Transformer;
import tech.tablesaw.api.Table;

/**
 * @author Pierre Lecerf (plecerf@lumiomedical.com)
 * Created on 2020/02/28
 */
public class TablesawProcessor implements Transformer<Table, Table>
{
    private final TableProcessor processor;

    /**
     *
     * @param processor
     */
    public TablesawProcessor(TableProcessor processor)
    {
        this.processor = processor;
    }

    public TablesawProcessor(TableProcessor... processors)
    {
        this.processor = new CompositeProcessor(processors);
    }

    @Override
    public Table transform(Table input) throws TransformationException
    {
        try {
            return this.processor.process(input);
        }
        catch (TableProcessorException e) {
            throw new TransformationException(e.getMessage(), e);
        }
    }
}
