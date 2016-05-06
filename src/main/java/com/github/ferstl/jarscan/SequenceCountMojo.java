package com.github.ferstl.jarscan;

import org.adoptopenjdk.jitwatch.jarscan.IJarScanOperation;
import org.adoptopenjdk.jitwatch.jarscan.sequencecount.SequenceCountOperation;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * Count instruction sequences.
 *
 * @since 1.1
 */
@Mojo(
    name = "sequenceCount",
    aggregator = false,
    defaultPhase = LifecyclePhase.VERIFY,
    requiresDependencyCollection = ResolutionScope.TEST,
    requiresDependencyResolution = ResolutionScope.TEST,
    requiresDirectInvocation = false,
    threadSafe = true)
public class SequenceCountMojo extends AbstractJarScanMojo {

  /**
   * Report sequences of length n.
   *
   * @since 1.1
   */
  @Parameter(property = "length", defaultValue = "1")
  private int length;

  @Override
  protected IJarScanOperation createOperation() {
    return new SequenceCountOperation(this.length);
  }

}