package com.dzdy.springBoot.service;

/**
 * 邮件服务
 * @author wangzhiyong
 *
 */
public interface MailService {
	
	/**
	 * 发送邮件
	 * @param to 收件人
	 * @param subject 主题
	 * @param content 内容
	 */
	public void sendSimpleMail(String to, String subject, String content);
	/**
	 * 发送HTML邮件
	 * @param to
	 * @param subject
	 * @param content
	 */
	public void sendHtmlMail(String to, String subject, String content);
	/**
	 * 发送带附件的邮件
	 * @param to
	 * @param subject
	 * @param content
	 * @param filePath 附件地址
	 */
	public void sendAttachmentsMail(String to, String subject, String content,String filePath);
	/**
	 * 发送带静态资源的邮件
	 * @param to
	 * @param subject
	 * @param content
	 * @param rscPath 静态资源地址
	 * @param rscId 静态资源id
	 */
	public void sendInineResourceMail(String to, String subject, String content,String rscPath,String rscId);
}
