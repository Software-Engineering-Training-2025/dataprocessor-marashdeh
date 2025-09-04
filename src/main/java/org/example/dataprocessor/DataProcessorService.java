package org.example.dataprocessor;

import org.example.dataprocessor.enums.AnalysisType;
import org.example.dataprocessor.enums.CleaningType;
import org.example.dataprocessor.enums.OutputType;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

/**
 * Students ONLY implement the process(...) method below.
 *
 * Requirements:
 * - Order: Clean -> Analyze -> Output -> Return result
 * - Do NOT mutate the original input list
 * - Handle empties as specified in AnalysisType docs
 * - Output format EXACTLY: "Result = <value>"
 * - TEXT_FILE path: target/result.txt (create parent dirs, overwrite file)
 */
public class DataProcessorService {

    /**
     * Implement this method.
     */
    public double process(
            CleaningType cleaningType,
            AnalysisType analysisType,
            OutputType outputType,
            List<Integer> data) throws Exception {

        List<Integer> copy = new ArrayList<>(data);

        org.example.dataprocessor.clean.cleaningType cleaning = switch (cleaningType) {
            case REMOVE_NEGATIVES -> new org.example.dataprocessor.clean.REMOVE_NEGATIVES();
            case REPLACE_NEGATIVES_WITH_ZERO -> new org.example.dataprocessor.clean.REPLACE_NEGATIVES_WITH_ZERO();
        };
        List<Integer> cleaned = cleaning.clean(copy);

        org.example.dataprocessor.analyze.analysisType analysis = switch (analysisType) {
            case MEAN -> new org.example.dataprocessor.analyze.MEAN();
            case MEDIAN -> new org.example.dataprocessor.analyze.MEDIAN();
            case STD_DEV -> new org.example.dataprocessor.analyze.STD_DEV();
            case P90_NEAREST_RANK -> new org.example.dataprocessor.analyze.P90_NEAREST_RANK();
            case TOP3_FREQUENT_COUNT_SUM -> new org.example.dataprocessor.analyze.TOP3_FREQUENT_COUNT_SUM();
        };
        double result = analysis.analyze(cleaned);

        org.example.dataprocessor.output.outputType output = switch (outputType) {
            case CONSOLE -> new org.example.dataprocessor.output.console();
            case TEXT_FILE -> new org.example.dataprocessor.output.TextFile();
        };
        output.output(result);

        return result;
    }
}

