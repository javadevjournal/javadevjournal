package com.javadevjournal.springbootbatch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.StepListener;
import org.springframework.batch.core.scope.context.ChunkContext;

/**
 * @Author - Kunwar Vikas
 */
public class SPChunkListener implements ChunkListener {

    Logger logger = LoggerFactory.getLogger(SPChunkListener.class);

    @Override
    public void beforeChunk(ChunkContext chunkContext) {
        logger.info("beforeChunk");
    }

    @Override
    public void afterChunk(ChunkContext chunkContext) {
        logger.info("afterChunk");
    }

    @Override
    public void afterChunkError(ChunkContext chunkContext) {
        logger.info("afterChunkError");
    }
}
