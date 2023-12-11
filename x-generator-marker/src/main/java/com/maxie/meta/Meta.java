package com.maxie.meta;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * *
 *
 * @author: xujian
 * @create: 2023-12-10 18:33
 **/
@NoArgsConstructor
@Data
public class Meta {


    /**
     * name
     */
    private String name;
    /**
     * description
     */
    private String description;
    /**
     * basePackage
     */
    private String basePackage;
    /**
     * version
     */
    private String version;
    /**
     * author
     */
    private String author;
    /**
     * createTime
     */
    private String createTime;
    /**
     * fileConfig
     */
    private FileConfigDTO fileConfig;
    /**
     * modelConfig
     */
    private ModelConfigDTO modelConfig;

    /**
     * FileConfigDTO
     */
    @NoArgsConstructor
    @Data
    public static class FileConfigDTO {
        /**
         * inputRootPath
         */
        private String inputRootPath;
        /**
         * outputRootPath
         */
        private String outputRootPath;
        /**
         * type
         */
        private String type;
        /**
         * files
         */
        private List<FilesDTO> files;

        /**
         * FilesDTO
         */
        @NoArgsConstructor
        @Data
        public static class FilesDTO {
            /**
             * inputPath
             */
            private String inputPath;
            /**
             * outputPath
             */
            private String outputPath;
            /**
             * type
             */
            private String type;
            /**
             * generateType
             */
            private String generateType;
        }
    }

    /**
     * ModelConfigDTO
     */
    @NoArgsConstructor
    @Data
    public static class ModelConfigDTO {
        /**
         * models
         */
        private List<ModelsDTO> models;

        /**
         * ModelsDTO
         */
        @NoArgsConstructor
        @Data
        public static class ModelsDTO {
            /**
             * fieldName
             */
            private String fieldName;
            /**
             * type
             */
            private String type;
            /**
             * description
             */
            private String description;
            /**
             * defaultValue
             *
             */
            private Object defaultValue;
            /**
             * abbr
             */
            private String abbr;
        }
    }
}
