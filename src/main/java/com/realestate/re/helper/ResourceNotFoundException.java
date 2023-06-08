package com.realestate.re.helper;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String resourceName;
    private final String fieldName;
    private final long fieldValue;

    public ResourceNotFoundException(String message) {
        super(message);
        this.resourceName = null;
        this.fieldName = null;
        this.fieldValue = 0;
    }

    public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
        super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }
}

// package com.realestate.re.helper;

// public class ResourceNotFoundException extends RuntimeException {
//     private static long serialVersionUID = 1L;

//     String resourceName;
//     String fieldName;
//     long fieldValue;

//     public ResourceNotFoundException(String message) {
//         super(message);
//     }

//     public ResourceNotFoundException(String resourceName, String fieldName, long fieldValue) {
//         super(String .format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
//         this.resourceName = resourceName;
//         this.fieldName = fieldName;
//         this.fieldValue = fieldValue;
//     }

//     public static long getSerialversionuid() {
//         return serialVersionUID;
//     }

//     public static void setSerialversionuid(long serialversionuid) {
//         serialVersionUID = serialversionuid;
//     }

//     public String getResourceName() {
//         return resourceName;
//     }

//     public void setResourceName(String resourceName) {
//         this.resourceName = resourceName;
//     }

//     public String getFieldName() {
//         return fieldName;
//     }

//     public void setFieldName(String fieldName) {
//         this.fieldName = fieldName;
//     }

//     public long getFieldValue() {
//         return fieldValue;
//     }

//     public void setFieldValue(long fieldValue) {
//         this.fieldValue = fieldValue;
//     }
    
    
// }