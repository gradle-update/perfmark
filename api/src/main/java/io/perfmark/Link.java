/*
 * Copyright 2019 Google LLC
 *
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

package io.perfmark;

/**
 * A link represents a linkage between asynchronous tasks. A link is created inside of a started
 * task. The resulting {@link Link} object can then be passed to other asynchronous tasks to
 * associate them with the original task.
 *
 * <p>A source task may have multiple outbound links pointing to other tasks. However, calling
 * {@link Link#link()} only work if it is the first such call. Subsequent calls to {@code link()}
 * have no effect.
 */
public final class Link {

  final long linkId;

  Link(long linkId) {
    this.linkId = linkId;
  }

  /**
   * Associate this link with the most recently started task. There may be at most one inbound
   * linkage per task: the first call to {@code link()} decides which outbound task is the origin.
   */
  public void link() {
    PerfMark.link(linkId);
  }
}
