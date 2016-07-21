/**
 * This class file was automatically generated by jASN1 v1.5.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.modules.generated.x690.ber_example_3;

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

import org.openmuc.jasn1.compiler.modules.generated.x690.ber_example.*;
import org.openmuc.jasn1.compiler.modules.generated.x690.ber_example_2.*;

public class PersonnelRecordzz {

	public static class SubSeqOf_children {

		public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		public List<ChildInformationzz> seqOf = null;

		public SubSeqOf_children() {
			id = identifier;
			seqOf = new ArrayList<ChildInformationzz>();
		}

		public SubSeqOf_children(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public SubSeqOf_children(List<ChildInformationzz> seqOf) {
			id = identifier;
			this.seqOf = seqOf;
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
				for (int i = (seqOf.size() - 1); i >= 0; i--) {
					codeLength += seqOf.get(i).encode(os, true);
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
			if (explicit) {
				codeLength += id.decodeAndCheck(is);
			}

			BerLength length = new BerLength();
			codeLength += length.decode(is);

			while (subCodeLength < length.val) {
				ChildInformationzz element = new ChildInformationzz();
				subCodeLength += element.decode(is, true);
				seqOf.add(element);
			}
			if (subCodeLength != length.val) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length tag");

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
			StringBuilder sb = new StringBuilder("SEQUENCE OF{");

			if (seqOf == null) {
				sb.append("null");
			}
			else {
				Iterator<ChildInformationzz> it = seqOf.iterator();
				if (it.hasNext()) {
					sb.append(it.next());
					while (it.hasNext()) {
						sb.append(", ").append(it.next());
					}
				}
			}

			sb.append("}");

			return sb.toString();
		}

	}

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.APPLICATION_CLASS, BerIdentifier.CONSTRUCTED, 0);
	protected BerIdentifier id;

	public byte[] code = null;
	public Namezz name = null;

	public BerVisibleString title = null;

	public EmployeeNumberzz number = null;

	public Datezz dateOfHire = null;

	public Namezz nameOfSpouse = null;

	public SubSeqOf_children children = null;

	public PersonnelRecordzz() {
		id = identifier;
	}

	public PersonnelRecordzz(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PersonnelRecordzz(Namezz name, BerVisibleString title, EmployeeNumberzz number, Datezz dateOfHire, Namezz nameOfSpouse, SubSeqOf_children children) {
		id = identifier;
		this.name = name;
		this.title = title;
		this.number = number;
		this.dateOfHire = dateOfHire;
		this.nameOfSpouse = nameOfSpouse;
		this.children = children;
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
			if (children != null) {
				codeLength += children.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 3}
				os.write(0xa3);
				codeLength += 1;
			}
			
			codeLength += nameOfSpouse.encode(os, false);
			// write tag {CONTEXT_CLASS, CONSTRUCTED, 2}
			os.write(0xa2);
			codeLength += 1;
			
			codeLength += dateOfHire.encode(os, false);
			// write tag {CONTEXT_CLASS, PRIMITIVE, 1}
			os.write(0x81);
			codeLength += 1;
			
			codeLength += number.encode(os, true);
			
			codeLength += title.encode(os, false);
			// write tag {CONTEXT_CLASS, PRIMITIVE, 0}
			os.write(0x80);
			codeLength += 1;
			
			codeLength += name.encode(os, true);
			
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
			if (berIdentifier.equals(Namezz.identifier)) {
				name = new Namezz();
				subCodeLength += name.decode(is, false);
			}
			else if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
				title = new BerVisibleString();
				subCodeLength += title.decode(is, false);
			}
			else if (berIdentifier.equals(EmployeeNumberzz.identifier)) {
				number = new EmployeeNumberzz();
				subCodeLength += number.decode(is, false);
			}
			else if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				dateOfHire = new Datezz();
				subCodeLength += dateOfHire.decode(is, false);
			}
			else if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
				nameOfSpouse = new Namezz();
				subCodeLength += nameOfSpouse.decode(is, false);
			}
			else if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
				children = new SubSeqOf_children();
				subCodeLength += children.decode(is, false);
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
		sb.append("name: ").append(name);
		
		sb.append(", ");
		sb.append("title: ").append(title);
		
		sb.append(", ");
		sb.append("number: ").append(number);
		
		sb.append(", ");
		sb.append("dateOfHire: ").append(dateOfHire);
		
		sb.append(", ");
		sb.append("nameOfSpouse: ").append(nameOfSpouse);
		
		if (children != null) {
			sb.append(", ");
			sb.append("children: ").append(children);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

