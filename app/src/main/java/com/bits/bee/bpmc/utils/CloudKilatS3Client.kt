package com.bits.bee.bpmc.utils

import com.amazonaws.AmazonClientException
import com.amazonaws.ClientConfiguration
import com.amazonaws.Request
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.AWSCredentialsProvider
import com.amazonaws.http.HttpClient
import com.amazonaws.http.HttpMethodName
import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.internal.ServiceUtils
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest
import java.net.URL
import java.util.*


@Suppress("DEPRECATION")
class CloudKilatS3Client : AmazonS3Client {

    constructor(awsCredentials: AWSCredentials?) : super(awsCredentials)

    constructor(awsCredentials: AWSCredentials?, clientConfiguration: ClientConfiguration?) : super(
        awsCredentials,
        clientConfiguration
    )

    constructor(credentialsProvider: AWSCredentialsProvider?) : super(credentialsProvider) {}
    constructor(
        credentialsProvider: AWSCredentialsProvider?,
        clientConfiguration: ClientConfiguration?
    ) : super(credentialsProvider, clientConfiguration) {
    }

    constructor(clientConfiguration: ClientConfiguration?) : super(clientConfiguration) {}
    constructor(
        credentialsProvider: AWSCredentialsProvider?,
        clientConfiguration: ClientConfiguration?,
        httpClient: HttpClient?
    ) : super(credentialsProvider, clientConfiguration, httpClient) {
    }

    @Throws(AmazonClientException::class)
    override fun generatePresignedUrl(generatePresignedUrlRequest: GeneratePresignedUrlRequest): URL {
        val bucketName = generatePresignedUrlRequest.bucketName
        val key = generatePresignedUrlRequest.key
        if (generatePresignedUrlRequest.expiration == null) {
            generatePresignedUrlRequest.expiration =
                Date(System.currentTimeMillis() + 1000 * 60 * 15)
        }
        val httpMethod = HttpMethodName.valueOf(
            generatePresignedUrlRequest.method
                .toString()
        )

        // If the key starts with a slash character itself, the following method
        // will actually add another slash before the resource path to prevent
        // the HttpClient mistakenly treating the slash as a path delimiter.
        // For presigned request, we need to remember to remove this extra slash
        // before generating the URL.
        val request: Request<GeneratePresignedUrlRequest> = createRequest(
            bucketName, key,
            generatePresignedUrlRequest, httpMethod
        )

        // Otherwise use the default presigning method, which is hardcoded
        // to use QueryStringSigner.
        presignRequest(
            request,
            generatePresignedUrlRequest.method,
            bucketName,
            key,
            generatePresignedUrlRequest.expiration,
            null
        )

        // Remove the leading slash (if any) in the resource-path
        return ServiceUtils.convertRequestToUrl(request, true)
    }
}