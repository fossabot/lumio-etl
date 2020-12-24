package com.lumiomedical.etl;

import com.lumiomedical.flow.compiler.CompilationException;
import com.lumiomedical.flow.compiler.FlowCompiler;
import com.lumiomedical.flow.compiler.FlowRuntime;
import com.lumiomedical.flow.compiler.RunException;
import com.lumiomedical.flow.impl.pipeline.PipelineCompiler;
import com.lumiomedical.flow.io.input.Input;
import com.lumiomedical.flow.io.output.Output;
import com.lumiomedical.flow.node.Node;

import java.util.Collection;

/**
 * Starting point for building ETL classes.
 * Provides a basic framework for establishing:
 * - the ETL specifications (flow definitions)
 * - the compiler implementation to use
 *
 * @author Pierre Lecerf (plecerf@lumiomedical.com)
 * Created on 2020/03/09
 */
public abstract class ETL
{
    private FlowRuntime runtime;

    /**
     *
     * @throws ETLCompilationException
     */
    public final ETL compile() throws ETLCompilationException
    {
        try {
            var flows = this.provideFlows();

            this.runtime = this.provideCompiler().compile(flows);

            return this;
        }
        catch (CompilationException e) {
            throw new ETLCompilationException("An error occurred while attempting to compile the ETL pipeline.", e);
        }
    }

    /**
     *
     * @return
     * @throws ETLRunException
     */
    public final Output run() throws ETLRunException
    {
        return this.run(Input.empty());
    }

    /**
     *
     * @throws ETLRunException
     */
    public final Output run(Input input) throws ETLRunException
    {
        try {
            if (this.runtime == null)
                throw new ETLRunException("The ETL isn't ready for launch, please compile it before attempting to run it.");

            return this.runtime.run(input);
        }
        catch (RunException e) {
            throw new ETLRunException("An error occurred while running the pipeline.", e);
        }
    }

    /**
     *
     * @return
     */
    protected FlowCompiler provideCompiler()
    {
        return new PipelineCompiler();
    }

    /**
     *
     * @return
     * @throws ETLCompilationException
     */
    abstract protected Collection<Node> provideFlows() throws ETLCompilationException;
}
