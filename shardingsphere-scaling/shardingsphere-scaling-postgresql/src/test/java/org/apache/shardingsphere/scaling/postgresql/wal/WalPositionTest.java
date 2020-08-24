/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.scaling.postgresql.wal;

import org.junit.Test;
import org.postgresql.replication.LogSequenceNumber;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public final class WalPositionTest {
    
    @Test
    public void assertCompareTo() {
        WalPosition walPosition = new WalPosition(LogSequenceNumber.valueOf(100L));
        assertThat(walPosition.compareTo(null), is(1));
        assertThat(walPosition.compareTo(new WalPosition(LogSequenceNumber.valueOf(100L))), is(0));
    }
    
    @Test
    public void assertToJson() {
        WalPosition walPosition = new WalPosition(LogSequenceNumber.valueOf(100L));
        assertThat(walPosition.toJson().toString(), is("100"));
    }
}
