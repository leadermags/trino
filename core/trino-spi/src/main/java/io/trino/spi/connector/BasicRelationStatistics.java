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
package io.trino.spi.connector;

public class BasicRelationStatistics
{
    /**
     * Estimated row count
     */
    private final double rowCount;

    /**
     * Estimated data size in bytes
     */
    private final double dataSize;

    public BasicRelationStatistics(long rowCount, long dataSize)
    {
        if (Double.isNaN(rowCount)) {
            throw new IllegalArgumentException("NaN not allowed as rowCount");
        }
        if (Double.isNaN(dataSize)) {
            throw new IllegalArgumentException("NaN not allowed as dataSize");
        }
        this.rowCount = rowCount;
        this.dataSize = dataSize;
    }

    /**
     * Returns estimated row count.
     * It is guaranteed that retured value will not be NaN.
     */
    public double getRowCount()
    {
        return rowCount;
    }

    /**
     * Returns estimated data size.
     * It is guaranteed that retured value will not be NaN.
     */
    public double getDataSize()
    {
        return dataSize;
    }
}
