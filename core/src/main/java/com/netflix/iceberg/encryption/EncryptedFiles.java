/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.netflix.iceberg.encryption;

import com.netflix.iceberg.io.InputFile;
import com.netflix.iceberg.io.OutputFile;

import java.nio.ByteBuffer;

public class EncryptedFiles {

  public static EncryptedInputFile encryptedInput(
      InputFile encryptedInputFile, EncryptionKeyMetadata keyMetadata) {
    return new BaseEncryptedInputFile(encryptedInputFile, keyMetadata);
  }

  public static EncryptedInputFile encryptedInput(
      InputFile encryptedInputFile, ByteBuffer keyMetadata) {
    return encryptedInput(encryptedInputFile, new BaseEncryptionKeyMetadata(keyMetadata));
  }

  public static EncryptedInputFile encryptedInput(InputFile encryptedInputFile, byte[] keyMetadata) {
    return encryptedInput(encryptedInputFile, ByteBuffer.wrap(keyMetadata));
  }

  public static EncryptedOutputFile encryptedOutput(
      OutputFile encryptingOutputFile, EncryptionKeyMetadata keyMetadata) {
    return new BaseEncryptedOutputFile(encryptingOutputFile, keyMetadata);
  }

  public static EncryptedOutputFile encryptedOutput(
      OutputFile encryptingOutputFile, ByteBuffer keyMetadata) {
    return encryptedOutput(encryptingOutputFile, new BaseEncryptionKeyMetadata(keyMetadata));
  }

  public static EncryptedOutputFile encryptedOutput(OutputFile encryptedOutputFile, byte[] keyMetadata) {
    return encryptedOutput(encryptedOutputFile, ByteBuffer.wrap(keyMetadata));
  }

  private EncryptedFiles() {}
}
