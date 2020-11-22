package com.lumiomedical.etl.dataframe.processor.print;

import com.lumiomedical.etl.dataframe.processor.TableProcessor;
import tech.tablesaw.api.Table;

/**
 * @author Pierre Lecerf (plecerf@lumiomedical.com)
 * Created on 2020/03/01
 */
public class PrintColumnNamesProcessor implements TableProcessor
{
    @Override
    public Table process(Table table)
    {
        System.out.println(table.columnNames());

        return table;
    }
}
