package Core.IO.File;

public interface FileHeader
{
    String getIdentifier();

    String getFileFormatID();

    String getFormatBlockID();

    String getDataBlockID();

    int getFileSize();

    int getBlockSize();

    int getAudioFormat();

    int getNumberOfChannels();

    int getSampleRate();

    int getBytesPerSecond();

    int getBytesPerBlock();

    int getBitsPerSample();

    int getDataSize();
}
