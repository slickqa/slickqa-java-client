package com.slickqa.client.apiparts;

import com.slickqa.client.model.LogEntry;
import com.slickqa.client.model.Result;

import java.util.List;

/**
 * The ResultApi adds only one method to the RetrieveUpdateDeleteApi, addLogs.
 *
 * Created by jcorbett on 4/14/14.
 */
public interface ResultApi extends RetrieveUpdateDeleteApi<Result> {
    /**
     * Add log entries to an existing result.
     * @param logEntries The log entries to add to the result.
     * @return a complete list of log entries in the result after the add.
     */
    public List<LogEntry> addLogs(List<LogEntry> logEntries);
}
