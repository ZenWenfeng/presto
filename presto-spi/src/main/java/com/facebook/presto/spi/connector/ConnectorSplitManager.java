/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.presto.spi.connector;

import com.facebook.presto.spi.ColumnHandle;
import com.facebook.presto.spi.ConnectorPartition;
import com.facebook.presto.spi.ConnectorPartitionResult;
import com.facebook.presto.spi.ConnectorSession;
import com.facebook.presto.spi.ConnectorSplitSource;
import com.facebook.presto.spi.ConnectorTableHandle;
import com.facebook.presto.spi.ConnectorTableLayoutHandle;
import com.facebook.presto.spi.predicate.TupleDomain;

import java.util.List;

public interface ConnectorSplitManager
{
    /**
     * Gets the Partitions for the specified table.
     *
     * The TupleDomain indicates the execution filters that will be directly applied to the
     * data stream produced by this connector. Connectors are encouraged to take advantage of
     * this information to perform connector-specific optimizations.
     */
    @Deprecated
    default ConnectorPartitionResult getPartitions(ConnectorTransactionHandle transactionHandle, ConnectorSession session, ConnectorTableHandle table, TupleDomain<ColumnHandle> tupleDomain)
    {
        throw new UnsupportedOperationException("not yet implemented");
    }

    /**
     * Gets the Splits for the specified Partitions in the indicated table.
     */
    @Deprecated
    default ConnectorSplitSource getPartitionSplits(ConnectorTransactionHandle transactionHandle, ConnectorSession session, ConnectorTableHandle table, List<ConnectorPartition> partitions)
    {
        throw new UnsupportedOperationException("not yet implemented");
    }

    default ConnectorSplitSource getSplits(ConnectorTransactionHandle transactionHandle, ConnectorSession session, ConnectorTableLayoutHandle layout)
    {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
