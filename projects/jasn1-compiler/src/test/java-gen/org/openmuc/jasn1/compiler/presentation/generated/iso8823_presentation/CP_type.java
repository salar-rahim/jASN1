/**
 * This class file was automatically generated by jASN1 v1.5.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.presentation.generated.iso8823_presentation;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;


public class CP_type {

	public static class SubSeq_normal_mode_parameters {

		public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		public Protocol_version protocol_version = null;

		public Calling_presentation_selector calling_presentation_selector = null;

		public Called_presentation_selector called_presentation_selector = null;

		public Presentation_context_definition_list presentation_context_definition_list = null;

		public Default_context_name default_context_name = null;

		public Presentation_requirements presentation_requirements = null;

		public User_session_requirements user_session_requirements = null;

		public User_data user_data = null;

		public SubSeq_normal_mode_parameters() {
			id = identifier;
		}

		public SubSeq_normal_mode_parameters(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public SubSeq_normal_mode_parameters(Protocol_version protocol_version, Calling_presentation_selector calling_presentation_selector, Called_presentation_selector called_presentation_selector, Presentation_context_definition_list presentation_context_definition_list, Default_context_name default_context_name, Presentation_requirements presentation_requirements, User_session_requirements user_session_requirements, User_data user_data) {
			id = identifier;
			this.protocol_version = protocol_version;
			this.calling_presentation_selector = calling_presentation_selector;
			this.called_presentation_selector = called_presentation_selector;
			this.presentation_context_definition_list = presentation_context_definition_list;
			this.default_context_name = default_context_name;
			this.presentation_requirements = presentation_requirements;
			this.user_session_requirements = user_session_requirements;
			this.user_data = user_data;
		}

		public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {

			int codeLength;

			if (code != null) {
				codeLength = code.length;
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
			}
			else {
				codeLength = 0;
				if (user_data != null) {
					codeLength += user_data.encode(os, true);
				}
				
				if (user_session_requirements != null) {
					codeLength += user_session_requirements.encode(os, false);
					// write tag {CONTEXT_CLASS, PRIMITIVE, 9}
					os.write(0x89);
					codeLength += 1;
				}
				
				if (presentation_requirements != null) {
					codeLength += presentation_requirements.encode(os, false);
					// write tag {CONTEXT_CLASS, PRIMITIVE, 8}
					os.write(0x88);
					codeLength += 1;
				}
				
				if (default_context_name != null) {
					codeLength += default_context_name.encode(os, false);
					// write tag {CONTEXT_CLASS, CONSTRUCTED, 6}
					os.write(0xa6);
					codeLength += 1;
				}
				
				if (presentation_context_definition_list != null) {
					codeLength += presentation_context_definition_list.encode(os, false);
					// write tag {CONTEXT_CLASS, CONSTRUCTED, 4}
					os.write(0xa4);
					codeLength += 1;
				}
				
				if (called_presentation_selector != null) {
					codeLength += called_presentation_selector.encode(os, false);
					// write tag {CONTEXT_CLASS, PRIMITIVE, 2}
					os.write(0x82);
					codeLength += 1;
				}
				
				if (calling_presentation_selector != null) {
					codeLength += calling_presentation_selector.encode(os, false);
					// write tag {CONTEXT_CLASS, PRIMITIVE, 1}
					os.write(0x81);
					codeLength += 1;
				}
				
				if (protocol_version != null) {
					codeLength += protocol_version.encode(os, false);
					// write tag {CONTEXT_CLASS, PRIMITIVE, 0}
					os.write(0x80);
					codeLength += 1;
				}
				
				codeLength += BerLength.encodeLength(os, codeLength);
			}

			if (explicit) {
				codeLength += id.encode(os);
			}

			return codeLength;

		}

		public int decode(InputStream is, boolean explicit) throws IOException {
			int codeLength = 0;
			int subCodeLength = 0;
			BerIdentifier berIdentifier = new BerIdentifier();

			if (explicit) {
				codeLength += id.decodeAndCheck(is);
			}

			BerLength length = new BerLength();
			codeLength += length.decode(is);

			codeLength += length.val;

			if (length.val == 0) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
				protocol_version = new Protocol_version();
				subCodeLength += protocol_version.decode(is, false);
				if (subCodeLength == length.val) {
					return codeLength;
				}
				subCodeLength += berIdentifier.decode(is);
			}
			
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				calling_presentation_selector = new Calling_presentation_selector();
				subCodeLength += calling_presentation_selector.decode(is, false);
				if (subCodeLength == length.val) {
					return codeLength;
				}
				subCodeLength += berIdentifier.decode(is);
			}
			
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
				called_presentation_selector = new Called_presentation_selector();
				subCodeLength += called_presentation_selector.decode(is, false);
				if (subCodeLength == length.val) {
					return codeLength;
				}
				subCodeLength += berIdentifier.decode(is);
			}
			
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4)) {
				presentation_context_definition_list = new Presentation_context_definition_list();
				subCodeLength += presentation_context_definition_list.decode(is, false);
				if (subCodeLength == length.val) {
					return codeLength;
				}
				subCodeLength += berIdentifier.decode(is);
			}
			
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
				default_context_name = new Default_context_name();
				subCodeLength += default_context_name.decode(is, false);
				if (subCodeLength == length.val) {
					return codeLength;
				}
				subCodeLength += berIdentifier.decode(is);
			}
			
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 8)) {
				presentation_requirements = new Presentation_requirements();
				subCodeLength += presentation_requirements.decode(is, false);
				if (subCodeLength == length.val) {
					return codeLength;
				}
				subCodeLength += berIdentifier.decode(is);
			}
			
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 9)) {
				user_session_requirements = new User_session_requirements();
				subCodeLength += user_session_requirements.decode(is, false);
				if (subCodeLength == length.val) {
					return codeLength;
				}
				subCodeLength += berIdentifier.decode(is);
			}
			
			user_data = new User_data();
			int choiceDecodeLength = user_data.decode(is, berIdentifier);
			subCodeLength += choiceDecodeLength;
			if (subCodeLength == length.val) {
				return codeLength;
			}
			throw new IOException("Unexpected end of sequence, length tag: " + length.val + ", actual sequence length: " + subCodeLength);

			
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
			encode(os, false);
			code = os.getArray();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder("SEQUENCE{");
			boolean firstSelectedElement = true;
			if (protocol_version != null) {
				sb.append("protocol_version: ").append(protocol_version);
				firstSelectedElement = false;
			}
			
			if (calling_presentation_selector != null) {
				if (!firstSelectedElement) {
					sb.append(", ");
				}
				sb.append("calling_presentation_selector: ").append(calling_presentation_selector);
				firstSelectedElement = false;
			}
			
			if (called_presentation_selector != null) {
				if (!firstSelectedElement) {
					sb.append(", ");
				}
				sb.append("called_presentation_selector: ").append(called_presentation_selector);
				firstSelectedElement = false;
			}
			
			if (presentation_context_definition_list != null) {
				if (!firstSelectedElement) {
					sb.append(", ");
				}
				sb.append("presentation_context_definition_list: ").append(presentation_context_definition_list);
				firstSelectedElement = false;
			}
			
			if (default_context_name != null) {
				if (!firstSelectedElement) {
					sb.append(", ");
				}
				sb.append("default_context_name: ").append(default_context_name);
				firstSelectedElement = false;
			}
			
			if (presentation_requirements != null) {
				if (!firstSelectedElement) {
					sb.append(", ");
				}
				sb.append("presentation_requirements: ").append(presentation_requirements);
				firstSelectedElement = false;
			}
			
			if (user_session_requirements != null) {
				if (!firstSelectedElement) {
					sb.append(", ");
				}
				sb.append("user_session_requirements: ").append(user_session_requirements);
				firstSelectedElement = false;
			}
			
			if (user_data != null) {
				if (!firstSelectedElement) {
					sb.append(", ");
				}
				sb.append("user_data: ").append(user_data);
				firstSelectedElement = false;
			}
			
			sb.append("}");
			return sb.toString();
		}

	}

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 17);
	protected BerIdentifier id;

	public byte[] code = null;
	public Mode_selector mode_selector = null;

	public SubSeq_normal_mode_parameters normal_mode_parameters = null;

	public CP_type() {
		id = identifier;
	}

	public CP_type(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public CP_type(Mode_selector mode_selector, SubSeq_normal_mode_parameters normal_mode_parameters) {
		id = identifier;
		this.mode_selector = mode_selector;
		this.normal_mode_parameters = normal_mode_parameters;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {

		int codeLength;

		if (code != null) {
			codeLength = code.length;
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
		}
		else {
			codeLength = 0;
			if (normal_mode_parameters != null) {
				codeLength += normal_mode_parameters.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 2}
				os.write(0xa2);
				codeLength += 1;
			}
			
			codeLength += mode_selector.encode(os, false);
			// write tag {CONTEXT_CLASS, CONSTRUCTED, 0}
			os.write(0xa0);
			codeLength += 1;
			
			codeLength += BerLength.encodeLength(os, codeLength);
		}

		if (explicit) {
			codeLength += id.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is, boolean explicit) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerIdentifier berIdentifier = new BerIdentifier();

		if (explicit) {
			codeLength += id.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		while (subCodeLength < length.val) {
			subCodeLength += berIdentifier.decode(is);
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
				mode_selector = new Mode_selector();
				subCodeLength += mode_selector.decode(is, false);
			}
			else if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
				normal_mode_parameters = new SubSeq_normal_mode_parameters();
				subCodeLength += normal_mode_parameters.decode(is, false);
			}
		}
		if (subCodeLength != length.val) {
			throw new IOException("Length of set does not match length tag, length tag: " + length.val + ", actual set length: " + subCodeLength);

		}
		codeLength += subCodeLength;

		return codeLength;
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("mode_selector: ").append(mode_selector);
		
		if (normal_mode_parameters != null) {
			sb.append(", ");
			sb.append("normal_mode_parameters: ").append(normal_mode_parameters);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

